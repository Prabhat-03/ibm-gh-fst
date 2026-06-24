import pandas as pd
df = pd.read_csv("Activity17.csv")

print(df["Usernames"])
print(df["Usernames"][1], df["Passwords"][1])
print(df.sort_values("Usernames"))
print(df.sort_values("Passwords", ascending= False))