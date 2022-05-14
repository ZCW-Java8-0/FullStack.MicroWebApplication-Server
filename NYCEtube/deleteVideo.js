const AWS = require('aws-sdk');
const config = require('./tsconfig.json');
const fs = require('fs');
const s3 = new AWS.S3({
    accessKeyId: process.env.AWS_ACCESS_KEY_ID,
    secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY
});

// var params = {  Bucket: 'zcw-cohort8zero', Key: 'sora.mp4' };

// s3.deleteObject(params, function(err, data) {
//   if (err) console.log(err, err.stack);  // error
//   else     console.log('File deleted');                 // deleted
// });

