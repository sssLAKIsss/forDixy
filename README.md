Дано:

  В организации было решено ввести справочник подразделений. 
Коды подразделений представлены в виде массива строк вида:

                      “K1\SK1”
                      “K1\SK2”
                      “K1\SK1\SSK1”
                      “K1\SK1\SSK2”
                      “K2”
                      “K2\SK1\SSK1”
                      “K2\SK1\SSK2”
где каждая строка включает в себя код данного подразделения, 
а также все коды подразделений, которые включают в свою структуру 
данное подразделение (к примеру департамент K1 включает в себя 
службу SK1, включающую в себя отдел SSK1). Подразделения в одной 
строке разделены знаком “\”. Возможны случаи, когда в массиве 
отсутствуют строки с кодом верхнеуровнего подразделения (в 
показанном выше массиве есть строки с подразделением K1, но данный 
код подразделения не представлен отдельной строкой “K1”, аналогичный 
случай с кодом K2\SK1), в таком случае необходимо добавить строку с 
кодом данного подразделения и учитывать ее при сортировке.

Задача:
Реализовать сортировку массива кодов подразделений по убыванию, 
при котором сохранялась бы иерархическая структура. Отсортированный 
тестовый массив должен иметь вид:

                         “K2”
                        “K2\SK1”
                        “K2\SK1\SSK2”
                        “K2\SK1\SSK1”
                        “K1”
                        “K1\SK2”
                        “K1\SK1”
                        “K1\SK1\SSK2”	
                        “K1\SK1\SSK1”
