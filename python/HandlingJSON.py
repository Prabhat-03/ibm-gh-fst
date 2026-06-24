import json
import pandas as pd

#reading the file
with open('Currency.json', 'r') as myFile:
    data = myFile.read()

#using Pandas
#df = pandas.json_normalize(json.loads(data))
df = pd.read_json("Currency.json", orient = "index")


#parsing the file
obj = json.loads(data)

print("usd " + str(obj["usd"]))
print("eur " + str(obj["eur"]))
print("gbp " + str(obj["gbp"]))

print(df)