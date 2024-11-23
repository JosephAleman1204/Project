const fs = require('fs');
const csv = require('csv-parser');

exports.procesarCSV = (rutaArchivo) => {
  return new Promise((resolve, reject) => {
    const resultados = [];
    fs.createReadStream(rutaArchivo)
      .pipe(csv())
      .on('data', (data) => resultados.push(data))
      .on('end', () => resolve(resultados))
      .on('error', reject);
  });
};
