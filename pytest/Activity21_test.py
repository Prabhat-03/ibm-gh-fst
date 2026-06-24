import pytest

def test_sum():
    a = 35
    b = 30
    sum = a + b
    assert sum == 65

def test_diff():
    a = 45
    b = 25
    diff = a - b
    assert diff == 20

def test_prod():
    a = 40
    b = 30
    prod = a * b
    assert prod == 1200

def test_div():
    a = 50
    b = 2
    div = a/b
    assert div == 25