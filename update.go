package main

import (
	"bufio"
	"encoding/json"
	"fmt"
	"io"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"regexp"
	"strings"
)

const (
	header = `<resources>
    <string name="app_name">Font Awesome</string>

`
	footer = `</resources>
`
)

func main() {
	version := getVersion()
	updateStringsResource(version)

	updateFontFile()
}

type version struct {
	Version string `json:"version"`
}

func getVersion() string {
	res, err := http.Get("https://raw.githubusercontent.com/FortAwesome/Font-Awesome/master/package.json")
	if err != nil {
		log.Fatal(err)
	}
	defer res.Body.Close()

	var data version
	if err := json.NewDecoder(res.Body).Decode(&data); err != nil {
		log.Fatal(err)
	}

	return data.Version
}

func updateStringsResource(version string) {
	output, err := os.Create("./fontawesome/src/main/res/values/strings.xml")
	if err != nil {
		log.Fatal(err)
	}
	defer output.Close()

	fmt.Fprint(output, header)
	fmt.Fprintf(output, "    <!-- Font Awesome v%s -->\n", version)

	printFontResources(output)

	fmt.Fprint(output, footer)
}

func printFontResources(w io.Writer) {
	res, err := http.Get("https://raw.githubusercontent.com/FortAwesome/Font-Awesome/master/src/icons.yml")
	if err != nil {
		log.Fatal(err)
	}
	defer res.Body.Close()

	var id, code string

	scanner := bufio.NewScanner(res.Body)
	for scanner.Scan() {
		line := scanner.Text()

		reID := regexp.MustCompile(`\s+id:\s+(.*)`)
		matchID := reID.FindStringSubmatch(line)
		if len(matchID) > 0 {
			id = matchID[1]
		}

		reCode := regexp.MustCompile(`\s+unicode:\s+(.*)`)
		matchCode := reCode.FindStringSubmatch(line)
		if len(matchCode) > 0 {
			code = matchCode[1]

			if id != "" {
				id = strings.Replace(id, "-", "_", -1)

				fmt.Fprintf(w, "    <string name=\"fa_%s\">&#x%s;</string>\n", id, code)

				id = ""
			}
		}
	}
}

func updateFontFile() {
	res, err := http.Get("https://github.com/FortAwesome/Font-Awesome/blob/master/fonts/fontawesome-webfont.ttf?raw=true")
	if err != nil {
		log.Fatal(err)
	}
	defer res.Body.Close()

	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		log.Fatal(err)
	}

	output, err := os.Create("./fontawesome/src/main/assets/fontawesome-webfont.ttf")
	if err != nil {
		log.Fatal(err)
	}
	defer output.Close()

	output.Write(body)
}
