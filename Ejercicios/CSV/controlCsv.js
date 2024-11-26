let datos = csv.trim().split('\n').slice(1).map(row => {
    let columnas = row.split(',');
    return {
        'product.partNumber': columnas[0],
        'location.locationIdentifier': columnas[1],
        'startDate': columnas[2],
        'duration': columnas[3],
        'planParentType': columnas[4],
        'planType': columnas[5],
        'quantity': columnas[6],
        'quantityUnits': columnas[7],
        'planningCycle': columnas[8],
        'source': columnas[9],
        'sourceLink': columnas[10]
    }
});

let table = document.querySelector('#miTabla tbody');
datos.forEach(fila => {
    let tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${fila['product.partNumber']}</td>
      <td>${fila['location.locationIdentifier']}</td>
      <td>${fila.startDate}</td>
      <td>${fila.duration}</td>
      <td>${fila.planParentType}</td>
      <td>${fila.planType}</td>
      <td>${fila.quantity}</td>
      <td>${fila.quantityUnits}</td>
      <td>${fila.planningCycle}</td>
      <td>${fila.source}</td>
      <td><a href="${fila.sourceLink}">Link</a></td>
    `;
    table.appendChild(tr);
});