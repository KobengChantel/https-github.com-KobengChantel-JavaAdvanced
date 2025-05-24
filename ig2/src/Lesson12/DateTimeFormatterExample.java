/**
 * To change this license header,
 * choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 *and open the template in the editor
 */

package Lesson12;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author tmcginn
 */
public class DateTimeFormatterExample {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    }
}
