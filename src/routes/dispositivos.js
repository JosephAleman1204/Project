const express = require('express');
const multer = require('multer');
const { validarDispositivos } = require('../controllers/dispositivos');

const upload = multer({ dest: 'uploads/' });
const router = express.Router();

router.post('/validar', upload.single('archivo'), validarDispositivos);

module.exports = router;
