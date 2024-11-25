package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date){
        try {
            // subStringを使ってyyyymmddを年、月、日に分ける
            int year = Integer.parseInt( date.substring(0, 4) );
            int month = Integer.parseInt( date.substring(4, 6) ) - 1; // Calendarクラスの月は0から始まるため、-1をする
            int day = Integer.parseInt( date.substring(6, 8) );

            // Calendarクラスを使用して曜日を取得
            Calendar cal = Calendar.getInstance();
            cal.set(year, month, day);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            // 曜日を文字列に変換
            // 曜日を示すint型が1~7で出力されるため、0に該当する箇所には入力なし
            String[] weekDays = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            return weekDays[dayOfWeek];

        } catch (Exception e) {
            // 桁数が足りない場合にエラーを表示する
            return "日付は『yyyymmdd』の形式で入力してください。";
        }
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return String.valueOf(res);
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return String.valueOf(res);
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return String.valueOf(res);
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return String.valueOf(res);
    }

}
