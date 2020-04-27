var fetchit=function(){
    
    var choice = document.getElementById("choice").value;
    var preference = document.getElementById("preference").value;
    console.log(choice+","+typeof choice);
    if(preference.toString().length==0)
    {
        
        alert("Please give your preference");
    }
    else{

        if(choice === "First 4 digits"){

            if(preference.toString().length!=4)
            {
                alert("Only 4 digit number is accepted");
            }
            else{
                for(var i=0;i<10;i++){
                    makeList(preference.toString(),generate());
                }
            }
        }
        else if(choice === "Last 4 digits"){
            if(preference.toString().length!=4)
            { 
                alert("Only 4 digit numberis accepted");
            }

            else{
                for(var i=0;i<10;i++){
                    makeList(generate(),preference.toString());
                }
            }
        }
        else  {
            if(preference.toString().length!=10)
            {
                alert("Only 10 digit number is accepted");
            }
            else{
                let element = document.createElement("option");
                element.value=element.text=preference.toString();
                let select = document.getElementById("select");
                select.add(element);
            }
        }
    }
}

var generate = function(){
    return Math.floor(Math.floor(Math.random()*90000) + 10000).toString();
}

var makeList = function(){
    let element = document.createElement("option");
    element.value=element.text=arguments[0]+arguments[1];
    let select = document.getElementById("select");
    select.add(element);
}


