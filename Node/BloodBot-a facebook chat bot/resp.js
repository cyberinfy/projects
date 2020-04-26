module.exports.sendMessage = function(event) {
 
    var reqC = require('./requestorContext');
    var donC = require('./donorContext');
  
    

    var tmp = "",
        navig = "",
        ok = "ok";
let sender = "";
const apiaiApp = require('apiai')("a1bcb399de5e42de987a5d3fb6b947eb");
    var fb = require('./fbs');
    
    sender = event.sender.id;

    let text = event.message.text;
    var sr = JSON.stringify(text);
    var temp = sr.toLowerCase();
    console.log(temp);

    console.log(sender);
    var da1 = {
        id: sender,
        text: temp
    }



    let apiai = apiaiApp.textRequest(text, {
        sessionId: sender
    });

    apiai.on('response', (response) => {
        // Got a response from api.ai. Let's POST to Facebook Messenger
        let aiText = response.result.fulfillment.speech;
        
        if (response.result.action) {

            tmp = response.result.parameters;

        }
               
                navig=donC.donor(aiText, sender, temp, tmp);
                if(navig == 0)
                
                navig=reqC.requestor(aiText, sender, temp, ok, tmp);
else navig = "";



    });


    apiai.on('error', (error) => {
        console.log(error);
    });

    apiai.end();

}



module.exports.sendpostback = function(a, idnum) {
    var reqC = require('./requestorContext');

    
    var str = a.substring(a.length, a.length - 1);
    var nid = a.substring(0, a.length - 1);
    nid = nid.toString();
    if (str === '1')
        reqC.intim(idnum, nid);
    else if (str === '2')
        reqC.intim1(idnum, nid);
    else if (str === '3')
        reqC.intim2(idnum, nid);

}
