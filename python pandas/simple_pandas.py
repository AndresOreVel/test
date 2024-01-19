import pandas as pd  # pip install pandas
# pip3 install pandas


def show_stats(df):
    # Mostrar las primeras filas del DataFrame
    print(df.head())

    # calcular estadisticas basicas
    promedio_tiempo = df['tiempo'].mean()
    porcentaje_respuestas_correctas = (df['correcta'].sum() / len(df)) * 100

    print(f"promedio tiempo de respuestas: {promedio_tiempo:.2f} segundos ")

    print(
        f"porcentaje de respuestas correctas {porcentaje_respuestas_correctas:.2f}%")

    # Agrupar por "indice_pregunta" y calcular estadísticas
    resultados_por_pregunta = df.groupby('indice_pregunta').agg(
        promedio_tiempo=('tiempo', 'mean'),
        porcentaje_respuestas_correctas=('correcta', 'mean')
    )

    # Renombrar las columnas
    resultados_por_pregunta = resultados_por_pregunta.rename(columns={
        'promedio_tiempo': 'Promedio de Tiempo (segundos)',
        'porcentaje_respuestas_correctas': 'Porcentaje de Respuestas Correctas (%)'
    })

    # Mostrar los resultados por pregunta
    print(resultados_por_pregunta)


# Leer el JSON y cargarlo en un DataFrame
df = pd.read_json('respostes.json')

show_stats(df)
# Filtrar resultados con tiempo inferior a 5 segundos
resultados_inferiores_a_5 = df[df['tiempo'] < 5]

# Mostrar los resultados filtrados
print(resultados_inferiores_a_5)

# Eliminar resultados con tiempo inferior a 5 segundos
df = df[df['tiempo'] >= 5]

show_stats(df)
