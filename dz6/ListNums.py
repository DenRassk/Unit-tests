"""Модуль расчёта среднего значения списка чисел и их сравнения у двух списков"""
class ListNums:
    """Класс списка чисел"""
    def __init__(self, list_nums: list[int | float]):
        self.list_nums = list_nums

    def get_list_average_value(self) -> float | int:
        """функция расчёта среднего значения списка чисел"""
        average_value = 0
        if self.list_nums:
            average_value = sum(self.list_nums) / len(self.list_nums)

        return average_value

    def averages_compare(self, other) -> None:
        """Функция сравнения среднего значения двух списков чисел"""
        averages_compare1 = self.get_list_average_value()
        averages_compare2 = other.get_list_average_value()
        if averages_compare1 > averages_compare2:
            print('Первый список имеет большее среднее значение')
        elif averages_compare1 < averages_compare2:
            print('Второй список имеет большее среднее значение')
        else:
            print('Средние значения списков равны')
