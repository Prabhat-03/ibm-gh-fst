import pytest


def test_sum(numList):
    sum = 0
    for i in range(len(numList)):
        sum += i

    assert sum == 55