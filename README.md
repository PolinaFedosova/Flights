Нужно перейти в директорию Flight.
Компиляция:

javac -cp /Users/polinafedosova/.m2/repository/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar:. -d target/ src/main/java/PolinaF/Main.java 

Переходим в папку target

Разархивирует нужную библиотеку :
jar -xvf /Users/polinafedosova/.m2/repository/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar target/

Запустим проект:
java -cp target/ PolinaF.Main
