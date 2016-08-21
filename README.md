# font-awesome-android
[![Travis](https://travis-ci.org/eqot/font-awesome-android.svg?branch=master)](https://travis-ci.org/eqot/font-awesome-android/builds)
[![Download](https://api.bintray.com/packages/eqot/maven/font-awesome-android/images/download.svg) ](https://bintray.com/eqot/maven/font-awesome-android/_latestVersion)
[![Apache2](http://img.shields.io/badge/license-APACHE2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


A [Font Awesome](http://fontawesome.io/) library for Android.

![font-awesome-android](https://dl.dropboxusercontent.com/u/972960/Documents/font-awesome-android/font-awesome-android.png)

## Download

Gradle:
```
dependencies {
    compile 'com.eqot:font-awesome-android:0.1.0'
}
```

Maven:
```
<dependency>
  <groupId>com.eqot</groupId>
  <artifactId>font-awesome-android</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
```

## Sample usage

You can define strings with Font Awesome icons in ```strings.xml```
with icons IDs (like ```fa-smile-o```) in [the cheatsheet](http://fontawesome.io/cheatsheet/).

```
<resources>
    <string name="label1">This is an example {fa-smile-o} {fa-thumbs-o-up}</string>
    <string name="label2">{fa-font-awesome} Font Awesome</string>
</resources>
```

The strings can be utilized in the usual style.

```
<LinearLayout
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label1"/>

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label2"/>

</LinearLayout>
```

FontAwesome#applyToAllViews() will replace icon IDs with unicode strings and set a proper font.

```
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontAwesome.applyToAllViews(this, findViewById(R.id.activity_main));
    }
}
```


## LICENSE

    Copyright 2016 Ikuo Terado

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
