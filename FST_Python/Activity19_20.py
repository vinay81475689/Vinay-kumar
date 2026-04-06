import pandas as pd
from pandas import DataFrame, ExcelWriter

data = {
    
    "Firstname" : ["Sathvik", "Avinash", "Lahari"],
    "Lastname"  :["Shah", "Kati", "Rath"],
    "Email"     : ["gwhwu@gmail.com","gwhswu@gmail.com","gwhus@gmail.com"],
    "Phonenumber" :["9292828228", "9288929292", "92020100929"]
}

#convert data to a frame

df= pd.DataFrame(data)

#create the excel writer object

writer = ExcelWriter("resourse/emp.xlsx")

#write a excel file
df.to_excel(writer, sheet_name="Sheet1", index=False)

#save and close the file

writer.close()

input_excel = pd.read_excel("resourse/emp.xlsx", sheet_name="Sheet1")
# Read data from Excel sheet


# Print the dataframe
print(input_excel)

# Print the number of rows and columns
print("====================================")
print("Number of rows and columns:", input_excel.shape)

# Print the data in the emails column only
print("====================================")
print("Emails:")
print(input_excel['Email'])

# Sort the data based on FirstName in ascending order and print the data
print("====================================")
print("Sorted data:")
print(input_excel.sort_values('FirstName'))