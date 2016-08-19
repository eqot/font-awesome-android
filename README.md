# font-awesome-android
[![Travis](https://travis-ci.org/eqot/font-awesome-android.svg?branch=master)](https://travis-ci.org/eqot/font-awesome-android/builds)
[![Download](https://api.bintray.com/packages/eqot/maven/font-awesome-android/images/download.svg) ](https://bintray.com/eqot/maven/font-awesome-android/_latestVersion)
[![Apache2](http://img.shields.io/badge/license-APACHE2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


A [Font Awesome](http://fontawesome.io/) library for Android.

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

```
<android.support.constraint.ConstraintLayout
    android:id="@+id/activity_main"
    ...
    />

    <TextView
        android:text="Hello World! {fa-thumbs-o-up}"
        android:id="@+id/text"
        ...
        />
```

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
