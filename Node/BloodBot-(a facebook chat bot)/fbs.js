const request = require('request');

module.exports.send = function (sender, aiText) {
    request({
        url: 'https://graph.facebook.com/v2.6/me/messages',
        qs: {
            access_token: "EAAbWlw3bHA0BAKJb9yE27JxgW9KFKw6sWmwsdw0Kt5Pvw4qxiNsIzJkoPZAO0bWIwDHD3kZCGZCZBaQmhhY9CxB6joZBeuOtPv6IsSrjZBZA2BoUTEv0oK448ibovYCH5UneOhSp8wNwQFACoh6FeTsNGu605l3z0r02h6ZBPPppUgZDZD"
        },
        method: 'POST',
        json: {
            recipient: {
                id: sender
            },
            message: {
                text: aiText
            }
        }
    }, (error, response) => {
        if (error) {
            console.log('Error sending message: ', error);
        } else if (response.body.error) {
            console.log('Error: ', response.body.error);
        }
    });
}

module.exports.senda = function (sender, pl) {
    var pl1=pl.toString()+'1',pl2=pl.toString()+'2',pl3=pl.toString()+'3';
    console.log(pl1,pl2,pl3);
    request({
        url: 'https://graph.facebook.com/v2.6/me/messages',
        qs: {
            access_token: "EAAbWlw3bHA0BAKJb9yE27JxgW9KFKw6sWmwsdw0Kt5Pvw4qxiNsIzJkoPZAO0bWIwDHD3kZCGZCZBaQmhhY9CxB6joZBeuOtPv6IsSrjZBZA2BoUTEv0oK448ibovYCH5UneOhSp8wNwQFACoh6FeTsNGu605l3z0r02h6ZBPPppUgZDZD"
        },
        method: 'POST',
        json: {
            recipient: {
                id: sender
            },
            message: {
                attachment: {
                    type: 'template',
                    payload: {
                        template_type: 'button',
                        text: 'select',
                        buttons: [
           
                            {
                                type: 'postback',
                                title: 'Yes',
                                payload: pl1
          },
                                                    {
                                type: 'postback',
                                title: 'Cancel',
                                payload: pl2
          },
                            {
                                type: 'postback',
                                title: 'No',
                                payload: pl3
          }
        ]
                       
    
        
                    }
                }
            }
        }
    }, (error, response) => {
        if (error) {
            console.log('Error sending message: ', error);
        } else if (response.body.error) {
            console.log('Error: ', response.body.error);
        }
    });
}
