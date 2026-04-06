import pandas as pd

data = {
    "username": ["admin", "Charles", "Deku"],
    "password": ["password","Charles13","AllMight"]
}

df = pd.DataFrame(data)

df.to_csv(path_or_buf="resourse/creds.csv", index=False)

#to read the csv file
csv_input=pd.read_csv("resourse/creds.csv")

print(csv_input)
#print values from the username column
print(csv_input["username"])

#print username password of the second row
print(f"username : {csv_input["username"][1]} and password: {csv_input["password"][1]}")

#sort the usernames column data in ascending orderand print data
print(csv_input.sort_values("username",ascending=True))

#sort the passwords column in descending order and print data
print(csv_input.sort_values("password",ascending=False))