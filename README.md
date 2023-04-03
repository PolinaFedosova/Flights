Программа на языке программирования java, которая прочитает файл tickets2.json и рассчитает:
- среднее время полета между городами Владивосток и Тель-Авив
- 90-й процентиль времени полета между городами Владивосток и Тель-Авив
Программа должна вызываться из командной строки Linux, результаты должны текстовом виде.


Запуск из командной строки Linux:
1)Нужно перейти в директорию Flight.
2)Компиляция:
  javac -cp /Users/polinafedosova/.m2/repository/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar:. -d target/ src/main/java/PolinaF/Main.java 
3)Переходим в папку target
4)Разархивирует нужную библиотеку :
  jar -xvf /Users/polinafedosova/.m2/repository/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar target/
5)Запустим проект:
  java -cp target/ PolinaF.Main
