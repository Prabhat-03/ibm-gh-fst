import pandas as pd


# df = pd.read_csv("employees.csv")
# print(df)
# print(df["Name"][2])
# print(df["Hire Date"][3])


data = {
    "Vehicle Type" : ["Car", "Bike", "Aeroplane"],
    "Manufacturer" : ["Honda", "Kawasaki", "Airbus"],
    "Model" : ["Elevate", "Ninja 900", "A320"]
}

df2 = pd.DataFrame(data)
df2.to_csv("vehicles.csv", index = False)

# df2.reset_index(drop=True, inplace=True)