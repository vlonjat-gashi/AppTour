# AppTour
Show your apps key features in a cool way.

### About

Show to your users the purpose and the key functions of your app in a cool material way using the AppTour library.

### Screenshot

![img](http://i.imgur.com/fG2aNUn.gif)

### Features

- Pre made slides.
- Add your own custom slides.
- Next, Skip and Done buttons.

### Usage

Create a new **Activity** that extends from the **AppTour** and then in the **init** add the slides and configure the intro.

**Important**: Don't override the **onCreate** method. Use **init**.

```java
public class MainActivity extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int customSlideColor = Color.parseColor("#009866");

        //Create pre-created fragments
        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.cybr, "Presentations on the go",
                "Get stuff done with or without an internet connection.", Color.WHITE, Color.WHITE);

        Fragment secondSlide = MaterialSlide.newInstance(R.drawable.cybr, "Share and edit together",
                "Write on your own or invite more people to contribute.", Color.WHITE, Color.WHITE);

        //Add slides
        addSlide(firstSlide, firstColor);
        addSlide(secondSlide, secondColor);

        //Custom slide
        addSlide(new CustomSlide(), customSlideColor);

        //Customize tour
        setSkipButtonTextColor(Color.WHITE);
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.WHITE);
    }

    @Override
    public void onSkipPressed() {
        //Do something after clicking Skip button.
    }

    @Override
    public void onDonePressed() {
        //Do something after clicking Done button.
    }
}
```

### Get It

```
allprojects {
        repositories {
            jcenter()
        }
    }

    dependencies {
        compile 'com.vlonjatg.android:app-tour:1.0'
    }
```

### Customization

```java
//Set String value of the Skip button
setSkipText("Skip");

//Set String value of the Done button
setDoneText("Done");

//Set the text color of the skip button
setSkipButtonTextColor(Color.WHITE);

//Set the next button color to white
setNextButtonColorToWhite();

//Set the next button color to black
setNextButtonColorToBlack();

//Set the text color of the done button
setDoneButtonTextColor(Color.WHITE);

//Set the color of the separator between slide content and bottom controls
setSeparatorColor(Color.WHITE);

//Set the color of the active dot indicator
setActiveDotColor(Color.RED);

//Set the color of the inactive dot indicator
setInactiveDocsColor(Color.GRAY);

//Show the skip button
showSkip();

//Hide the skip button
hideSkip();

//Show the next button
showNext();

//Hide the next button
hideNext();

//Show the done button
showDone();

//Hide the done button
hideDone();

//Show indicator dots
showIndicatorDots();

//Hide indicator dots
hideIndicatorDots();
```

### Example

An [example](https://github.com/vlonjatg/AppTour/tree/master/sample) is available.

### Developed By

Vlonjat Gashi - [Twitter](https://twitter.com/vlonjatg)

### Attributes

This library is inspired by [AppIntro](https://github.com/PaoloRotolo/AppIntro) library.

### License

AppTour is available under the [MIT](http://opensource.org/licenses/MIT) licence.

```
The MIT License (MIT)

Copyright (c) 2015 Vlonjat Gashi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
