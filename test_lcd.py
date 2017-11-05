#use this library https://github.com/adafruit/Adafruit_Python_CharLCD.git
import Adafruit_CharLCD as LCD

rs = 22
en = 26
d4 = 5
d5 = 6
d6 = 13
d7 = 19
cols = 16
rows = 2

lcd = LCD.Adafruit_CharLCD(rs, en, d4, d5, d6, d7, cols, rows)

lcd.clear()
lcd.message('Mr.Shibata is\nhomo')
lcd.blink(True)
