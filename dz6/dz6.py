"""Запускалка-проверялка работы класса ListNums"""
from ListNums import ListNums

if __name__ == '__main__':
    listNum1 = ListNums([1, 2, 3])
    listNum2 = ListNums([2, 3, 0, 3])
    listNum3 = ListNums([1.65, 5])
    ListNums.averages_compare(listNum3, listNum2)
    ListNums.averages_compare(listNum1, listNum3)
    ListNums.averages_compare(listNum1, listNum2)
