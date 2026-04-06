import pytest

@pytest.fixture
def math_ops_inputs():
    return (10, 20)

@pytest.fixture
def wallet():
    amount = 0
    return amount

import pytest

# Global schema fixture
@pytest.fixture(scope="session")
def schemas():
    return {
        "User": ["id", "name", "email"],
        "Product": ["id", "name", "price"]
    }

# Inventory fixture
@pytest.fixture
def base_inventory():
    return [
        {"name": "Laptop", "price": 1000, "category": "Electronics"},
        {"name": "Phone", "price": 500, "category": "Electronics"},
        {"name": "TV", "price": 800, "category": "Electronics"},
        {"name": "Tablet", "price": 300, "category": "Electronics"},
        {"name": "Camera", "price": 600, "category": "Electronics"},
        {"name": "Speaker", "price": 200, "category": "Electronics"},
    ]

# HTML report header
def pytest_html_report_title(report):
    report.title = "Automation Test Report"

def pytest_report_header(config):
    return "Testing Sprint Version: 1.0.0"