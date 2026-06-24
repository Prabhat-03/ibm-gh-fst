import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

# df = pd.read_excel("employees.xlsx", sheet_name = "Sheet1")
# print(df)
# print(df["Name"][3], df["Salary"][3])


data = {
    "Vehicle Type" : ["Car", "Bike", "Aeroplane"],
    "Manufacturer" : ["Honda", "Kawasaki", "Airbus"],
    "Model" : ["Integra", "Ninja H2R", "A320"]
}

df = pd.DataFrame(data)
print(df)
writer = ExcelWriter("Vehicle.xlsx")
df.to_excel(writer, index = False)
writer.close()