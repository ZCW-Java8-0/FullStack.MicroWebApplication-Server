// export const UploadVideo = () => {
// const account = useAppSelector(state => state.authentication.account);

// const AWS = require('aws-sdk');
// const config = require('./tsconfig.json');
// const fs = require('fs');
// const s3 = new AWS.S3({
//     accessKeyId: process.env.AWS_ACCESS_KEY_ID,
//     secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY
// });

// require('dotenv').config();
// console.log(process.env);

// (async function() {
//     try {
//         AWS.config.setPromisesDependency();
//         AWS.config.update({
//             accessKeyId: process.env.AWS_ACCESS_KEY_ID,
//             secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY,
//             region: 'us-east-1'
//         })
        

        // const uploadFile = (fileName) => {
        //     const fileContent = fs.readFileSync(fileName);
        
        //     const params = {
        //         Bucket: "zcw-cohort8zero",
        //         Key: 'videoapp/sora.mp4',
        //         Body: fileContent
        //     };
        
        //     s3.upload(params, function(err, data) {
        //         if (err) {
        //             throw err;
        //         }
        //         console.log(`File uploaded successfully. ${data.Location}`);
        // });
        
        // };

//     } catch (e) {
//         console.log('our error', e);
//     }

// })();

// { 
//     uploadFile('src/main/webapp/content/videosample/sora.mp4');
// }

// function upload(videoName) {

//     (async () => {
//         await s3
//             .putObject({
//                 Body: fileStream,
//                 Bucket: "zcw-cohort8zero",
//                 Key: "videoapp/" + videoName
//     }).promise();
//     })();

// }

// {
// console.log(upload("sora.mp4"));
// }

//string concat string variable 

// }
// export default upload;

// var streamingS3 = require('streaming-s3'),
//     fs = require('fs');

// var fStream = fs.createReadStream('src/main/webapp/content/videosample/sora2.mp4');
// var uploader = new streamingS3(fStream, {accessKeyId: process.env.AWS_ACCESS_KEY_ID, secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY},
//   {
//     Bucket: 'zcw-cohort8zero',
//     Key: 'videoapp/sora1.mp4',
//     ContentType: 'video/mp4'
//   },  function (e, resp, stats) {
//   if (e) return console.log('Upload error: ', e);
//   console.log('Upload stats: ', stats);
//   console.log('Upload successful: ', resp);
//   }
// );