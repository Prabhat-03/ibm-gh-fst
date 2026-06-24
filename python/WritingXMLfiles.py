import pandas as pd

df = pd.DataFrame([[1, 3, 5],
                   [1.5, 3.5, 5.5],
                   [2, 4, 6]],
                   columns=['X', 'Y', 'Z'],
                   index=['One', 'Two', 'Three'])

df.to_xml("coordinates.xml", index = True, row_name='Numbers')