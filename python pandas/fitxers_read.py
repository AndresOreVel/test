# Leer datos desde un archivo
with open('fitxer.txt', 'r') as fitxer:
    contingut = fitxer.read()

print("Contingut del fitxer:")
print(contingut)
