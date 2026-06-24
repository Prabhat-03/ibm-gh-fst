import pytest

@pytest.fixture
def numList():
    l = list(range(11))
    return l

