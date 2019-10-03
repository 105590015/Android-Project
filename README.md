### 作業說明
---
1. Refer to Unit031, Unit035, Unit038, and Unit044 and develop a simple money bookkeeper app to record the money that the user spends on the meals according to the following requirements：
* The title of the app shall be "作業八: your name".
* The app shall have two Activities where the MainActivity (the first activity) shall allows users to enter the purchased meal , the purchased date, and the amount of the purchase. The purchased meal can be "Breakfast", "Lunch", or "Dinner" which can be selected by user using a spinner. The user may enter multiple purchases of the meals that he/she brought. The layout the MainActivity is shown in Fig. 8a.
* Moreover, when the user clicks datePicker (datePicker mode = spinner) and changes date, the purchased date picked by the user will be displayed on the TextView "日期". Further, when the user clicks the "輸入" Button, your app shall show the purchased amount that the user enters in the EditText "金額" using a Toast as shown in Fig. 8b.
* The user can keep entering the detailed information of each purchased meal in multiple times and all the entered data will be recorded in the MainActivity (may use arrays of primitive types or user-defined Serializable or Parcelable objects).
* When the user clicks the the "紀錄" Button on Fig. 8a, the MainActivity will pass all the recorded data to the second activity where the data will be displayed using a ListView as shown in Fig. 8c.
