# pylint: disable=redefined-outer-name
"""Модуль тестирования функций класса ListNums"""
import pytest
from _pytest.capture import capfd

from ListNums import ListNums


@pytest.fixture
def list_nums1():
    """Первый тестовыйй список"""
    return [2, 3, 4, 5, 7]


@pytest.fixture
def list_nums2():
    """Второй тестовый список"""
    return [2, 3, 4, 5, 6]


def test_init(list_nums1):
    """Проверка корректной инициализации класса"""
    test_list_nums = ListNums(list_nums1)
    assert test_list_nums.list_nums == list_nums1


@pytest.mark.parametrize('lst1, result', [([1, 2, 3], 2),
                                          ([1, -2], -0.5),
                                          ([], 0),
                                          ([1.2, 3.4], 2.3),
                                          ([5], 5),
                                          ([-23.5], -23.5)])
def test_empty_get_list_average_value(lst1, result):
    """Проверка правильности расчёта средних значений при разных входных значениях"""
    nums_list = ListNums(lst1)
    assert nums_list.get_list_average_value() == result


def test_first_average_more(list_nums1, list_nums2, capfd):
    """Проверка сообщения когда среднее значение первого списка больше второго"""
    ListNums.averages_compare(ListNums(list_nums1), ListNums(list_nums2))
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Первый список имеет большее среднее значение'


def test_second_average_more(list_nums1, list_nums2, capfd):
    """Проверка сообщения когда среднее значение второго списка больше первого"""
    ListNums.averages_compare(ListNums(list_nums2), ListNums(list_nums1))
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Второй список имеет большее среднее значение'


def test_equal_averages(list_nums1, capfd):
    """Проверка сообщения когда средние значения списков равны"""
    ListNums.averages_compare(ListNums(list_nums1), ListNums(list_nums1))
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Средние значения списков равны'
