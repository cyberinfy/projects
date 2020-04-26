const express = require('express');
var app = express();
var async = require('async');
var check = require('./check');
var resp = require('./resp');

var sM = [],vD=[];
for (i = 1; i <= 1000; i++) {
    vD[i] = Object.create(check);
    sM[i] = Object.create(resp);
    
}
const bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));
const server = app.listen(process.env.PORT || 3000, () => {
    console.log('Express server listening on port %d in %s mode', server.address().port, app.settings.env);
});
app.get('/webhook', (req, res) => {
    if (req.query['hub.mode'] && req.query['hub.verify_token'] === 'stupid') {
        res.status(200).send(req.query['hub.challenge']);
    } else {
        res.status(403).end();
    }
});
/*---------------------------------------------- Handling all messenges and postbacks---------------------------------*/
app.post('/webhook', (req, res) => {
    if (req.body.object === 'page') {
        req.body.entry.forEach((entry) => {
            entry.messaging.forEach((event) => {
                wait(3000);
                if (event.message && event.message.text || (event.postback && event.postback.payload)) {
                    // console.log('in');
                    if (event.message && event.message.text) {
                        
                        var rob = Math.floor((Math.random() * 1000) + 1);

                       
                         vD[rob].checkD(event);
                    //    async.waterfall([
                     
                    //     function(callback){
                        
                    //     vD[rob].checkD({}, (err, data) => m=data; });
                    //     console.log('m='+m);
                        
                    //     callback();
                    // },
                    //     function(callback){
                    //         console.log('m='+m);
                    //     if(m == 0){
                    //         sM[rob].sendMessage(event);
                    //     }
                    
                    // }
                      
                    //     ]);


                    } else {
                        var a = event.postback.payload;
                        var idnum = event.sender.id;
                        console.log(a);
                        var rob = Math.floor((Math.random() * 1000) + 1);
                        sM[rob].sendpostback(a, idnum);
                    }
                } else {
                    console.log("Webhook received unknown event: ", event);
                }
            });
        });
        res.status(200).end();
    }
});

function wait(ms) {
    var start = new Date().getTime();
    var end = start;
    while (end < start + ms) {
        end = new Date().getTime();
    }
}
