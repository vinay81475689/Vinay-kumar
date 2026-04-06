import pytest

@pytest.mark.activity
def test_addition(math_ops_inputs):
    #input numbers
    #operation
    sum = math_ops_inputs[0] + math_ops_inputs[1]
    #assertion
    assert sum == 30

@pytest.mark.activity
def test_subraction(math_ops_inputs):
    #input numbers
    #operation
    sub = math_ops_inputs[0] - math_ops_inputs[1]
    #assertion
    assert sub == -10

@pytest.mark.activity
def test_multiplication(math_ops_inputs):
    #input numbers
    #operation
    mul = math_ops_inputs[0] * math_ops_inputs[1]
    #assertion
    assert mul == 200

@pytest.mark.activity
def test_division(math_ops_inputs):
    #input numbers
    #operation
    div = math_ops_inputs[0] / math_ops_inputs[1]
    #assertion
    assert div == 0.5

