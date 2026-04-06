#scenario 1
'''def validate_response(data, schema_type, schemas):
    required_keys = schemas.get(schema_type)
    for key in required_keys:
        if key not in data:
            raise ValueError(f"Missing '{key}' key in {schema_type} schema")
    return True'''
import pytest

class ValidationError(Exception):
    pass

def validate_response(data, schema_type, schemas):
    required_keys = schemas.get(schema_type)
    for key in required_keys:
        if key not in data:
            raise ValidationError(f"Missing '{key}' key in {schema_type} schema")
    return True

@pytest.mark.parametrize("data,schema_type,valid", [
    ({"id":1,"name":"Vinay","email":"v@test.com"}, "User", True),
    ({"id":2,"name":"Phone","price":500}, "Product", True),
    ({"id":3,"name":"TV","price":800}, "Product", True),
    ({"id":4,"name":"NoEmail"}, "User", False),
    ({"id":5,"price":100}, "Product", False),
])
def test_validate_response(data, schema_type, valid, schemas):
    if valid:
        assert validate_response(data, schema_type, schemas)
    else:
        with pytest.raises(ValidationError) as e:
            validate_response(data, schema_type, schemas)
        assert "Missing" in str(e.value)

#scenario 2
'''
def apply_bulk_discount(items, discount_rate=0.10):
    electronics = [i for i in items if i['category'] == 'Electronics']
    if len(electronics) > 5:
        for item in electronics:
            item['price'] *= (1 - discount_rate)
    return items '''
import pytest

def apply_bulk_discount(items, discount_rate=0.10):
    electronics = [i for i in items if i['category'] == 'Electronics']
    if len(electronics) > 5:
        for item in electronics:
            item['price'] *= (1 - discount_rate)
    return items

@pytest.mark.smoke
@pytest.mark.parametrize("discount", [0.10, 0.20])
def test_bulk_discount(base_inventory, discount):
    updated = apply_bulk_discount(base_inventory, discount)

    for item in updated:
        assert item['price'] < 1000  # basic validation

@pytest.mark.regression
def test_empty_inventory():
    assert apply_bulk_discount([]) == []

#scenario 3
'''
class DatabaseConnector:
    def connect(self):
        if random.random() < 0.2:  # 20% fail rate
            raise ConnectionError("Network Flake!")
        return "Connected"
    
'''
import pytest
import random
import os

class DatabaseConnector:
    def connect(self):
        if random.random() < 0.2:
            raise ConnectionError("Network Flake!")
        return "Connected"

    def execute(self):
        return "Data"

@pytest.fixture
def db():
    conn = DatabaseConnector()
    print("Connection Open")
    yield conn
    print("Connection Close")

@pytest.mark.skipif(os.getenv("NETWORK_OFFLINE") == "1", reason="Network offline")
@pytest.mark.xfail(reason="Known flaky connection (20% failure)")
def test_db_connection(db):
    assert db.connect() == "Connected"

def test_db_execute(db):
    db.connect()
    assert db.execute() == "Data"
#scenario 4
'''
class SmartLight:
    def __init__(self, status="OFF", brightness=0):
        self.status = status
        self.brightness = brightness

    def dim(self):
        if self.status == "OFF":
            self.status = "ON"
            self.brightness = 10
        else:
            self.brightness = max(0, self.brightness - 10)
            '''
import pytest

class SmartLight:
    def __init__(self, status="OFF", brightness=0):
        self.status = status
        self.brightness = brightness

    def dim(self):
        if self.status == "OFF":
            self.status = "ON"
            self.brightness = 10
        else:
            self.brightness = max(0, self.brightness - 10)

@pytest.fixture
def light(request):
    return SmartLight(**request.param)

@pytest.mark.hardware
@pytest.mark.brightness
@pytest.mark.parametrize("light", [
    {"status": "OFF", "brightness": 0},
], indirect=True)
def test_dim_turns_on(light):
    light.dim()
    assert light.status == "ON"
    assert light.brightness == 10

@pytest.mark.software_logic
@pytest.mark.parametrize("light", [
    {"status": "ON", "brightness": 50},
], indirect=True)
def test_dim_reduces_brightness(light):
    light.dim()
    assert light.brightness == 40