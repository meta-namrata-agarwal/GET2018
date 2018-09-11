function FNameValidate()
    {
        var first = document.getElementById("FirstName");
        if (first.value.length > 3)
                {
                for (var i=0;i<first.value.length;i++)
                        {  
                            var character=first.value.charAt(i);
                                var unicode=character.charCodeAt(0);
                            if(!(unicode>=97&&unicode<=122)&&!(unicode>=65&&unicode<=90))
                            {	
                                first.style.border="2px solid red";
                                return false;						
                            }
                        }
                        first.style.border="2px solid green";
                        return true;
                    }
                else
                    {
                        first.style.border="2px solid red";
                        return false;
                    }	
            }
function LNameValidate()
            {	
                var first=document.getElementById("LastName");
                if(first.value.length>3)
                    {
                        for(var i=0;i<first.value.length;i++)
                        {
                           
                            var character=first.value.charAt(i);
                            var unicode=character.charCodeAt(0);
                            if(!(unicode>=97&&unicode<=122)&&!(unicode>=65&&unicode<=90))
                            {	
                                first.style.border="2px solid red";
                                return false;						
                            }
                        }
                        first.style.border="2px solid green";
                        return true;
                    }
                else
                    {
                        first.style.border="2px solid red";
                        return false;
                    }	
            }
function ContatctNumberValidate()
            {
               
               var letters=/^[0-9]+$/;
               var x=document.getElementById("number");
               if(x.value.match(letters) && x.value.length>=8 && x.value.length<=11)
                   {
                       x.style.border="2px solid green";
                       return true;
                   }
               else
                   {
                       x.style.border="2px solid red";
                       return false;
                   }
           }
function validateEmail()
            {
               
                var email=document.getElementById("Email");
                if(email.value.length>=8)
                 {
                      var AttheRate=email.value.indexOf('@');
                      var dot=email.value.indexOf('.');
                     if(AttheRate>2 &&dot>AttheRate+2&&dot<email.value.length-3)
                         {
                             email.style.border="2px solid green";
                             return true;
                         }
                     else
                         {
                             email.style.border="2px solid red";
                             return false;
                         }
                 }
                else{
                    email.style.border="2px solid red";
                             return false;
                }
            }

function validatePassword() 
            {
              
            var strength = document.getElementById("strength");
            var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
            var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
            var enoughRegex = new RegExp("(?=.{6,}).*", "g");
            var pwd = document.getElementById("password");
            if (pwd.value.length==0) {
            strength.innerHTML = "Type Password";
                pwd.style.border="2px solid red";
                return false;
            } else if (false == enoughRegex.test(pwd.value)) {
            strength.innerHTML = "More Characters";
                pwd.style.border="2px solid red";
                return false;
            } else if (strongRegex.test(pwd.value)) {

            strength.innerHTML = "<span style='color:green'>Strong!</span>";
                pwd.style.border="2px solid green";
                return true;
            } else if (mediumRegex.test(pwd.value)) {
            strength.innerHTML = "<span style='color:orange'>Medium!</span>";
                pwd.style.border="2px solid orange";
                return true;
            } else {
            strength.innerHTML = "<span style='color:red'>Weak!</span>";
                pwd.style.border="2px solid yellow";
                return true;
            }
    }

function validateConfirmPassword()
    { 
        var Confpass=document.getElementById("confrimPass");
        var pass=document.getElementById("password");
        var matchPass=document.getElementById("match");
        if(!validatePassword())
            {
                matchPass.innerHTML="<span style='color:red'>First enter password!</span>";
                 Confpass.style.border="2px solid red";
                return false;
            }
        if(Confpass.value.match(pass.value))
            {
                matchPass.innerHTML="<span style='color:green'>password matched!</span>";
                 Confpass.style.border="2px solid green";
                return true;
            }
        else{
             matchPass.innerHTML="<span style='color:red'>password not matched!</span>";
                 Confpass.style.border="2px solid red";
                return false;
        }
    
function validateSubmit()
  {
        if (FNameValidate()&&LNameValidate()&&validateEmail()&&validatePassword()&&ContatctNumberValidate()&&validatePassword()&&validateConfirmPassword())
            return true;
         else
            return false;
  }
        


function validateLogIn()
{
    var mail=document.getElementById("Email");
    var pass=document.getElementById("password");
    if(mail.value.length!=0&& pass.value.length!=0){
        alert("login success");
        return true;
    }
    else{
        alert("login failed");
        return false;
    }
}
        
        