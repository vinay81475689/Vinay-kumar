import pytest
@pytest.mark.activity
@pytest.mark.parametrize("earned, spent, expected_balance", [(30,10,20), (20, 2, 18)])
def test_transactions(wallet, earned, spent, expected_balance):
    wallet += earned
    wallet -= spent
    assert wallet == expected_balance
