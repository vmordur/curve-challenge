# curve-challenge
App for Curve's development challenge.

## Usage 
The component responsible for the flashing behavior of the result text view is the `FlashingTextView`, which is an abstract class with two different extensions for two different implementations: `RxFlashingTextView` and `HandlerFlashingTextView`.


In order to use either one or the other implementation, it justs needs to be specified in the main screen layout `activity_main.xml` which class to use as the `resultTextView` element: 

* RxFlashingTextView

```XML
<com.challenge.curve.vmorapp.view.RxFlashingTextView
            android:id="@+id/resultTextView"
            style="@style/ResultTextViewStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:text="0" />

```
* HandlerFlashingTextView

```XML
<com.challenge.curve.vmorapp.view.HandlerFlashingTextView
            android:id="@+id/resultTextView"
            style="@style/ResultTextViewStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:text="0" />

```