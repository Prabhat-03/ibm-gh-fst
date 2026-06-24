import pandas as pd
data ={
    "Usernames" : ["admin", "Charles", "John"],
    "Passwords" : ["password", "Charles123", "AllMightyDoe"]
}

df = pd.DataFrame(data)
df.to_csv("Activity17.csv", index = False)