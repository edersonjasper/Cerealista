

// FUNCOES DIVERSAS => 001 ########################################################################

function get_tecla(e)
{
    //Esc
    if(e.keyCode == 27)
    {
        fecha_obj('cal_js');
    }
}

function fecha_obj(id)
{
    if(obj = get(id))
        document.body.removeChild(obj);
}


// FUNCOES NUMERICAS => 002 #######################################################################


function so_n(campo, evento)
{
    return(define_retorno(campo, evento, '0123456789'));
}


function define_retorno(obj, evento, retorno)
{
    if (obj.length ==0)
        obj.value=0;
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode;
    else if (evento)
        key = evento.which;
    else
        return true;
    keychar = String.fromCharCode(key);
    if((key==null) || (key==0) || (key==8) || (key==9)|| (key==13)|| (key==27))
        return true;
    else
    {
        if((retorno.indexOf(keychar) > -1))
            return true;
        else
            return false;
    }
}


function fmt_n(campo, sep_mil, sep_dec, cas_dec, evento)
{
    if (window.event)
        evento = window.event;

    len = campo.value.length;

    vlr = campo.value;
    if (len > 0)
    {
        var whichCode = (window.Event) ? evento.which : evento.keyCode;

        if(whichCode == 107) vlr = vlr.replace("-","");

        //alert(whichCode);
        if ((whichCode == 109) || (whichCode == 107) || (whichCode >= 48 && whichCode <= 57) || (whichCode >= 96 && whichCode <= 105) || (whichCode == 8) || (whichCode == 46) || (evento.type == 'blur'))
        {
            aux = fmt_valor(vlr, sep_mil, sep_dec, cas_dec);
            while (aux.length > campo.maxLength)
            {
                aux2 = aux.substring(0, aux.length -1);
            //aux  = floattostr(valor)
            }
            campo.value = aux;
        }
    }
}


function str_float(valor)
{
    valor = valor.toString();
    retorno = valor;
    retorno = retorno.replace(/[.]/gi, '');
    retorno = retorno.replace(/[,]/gi, '.');
    if (parseFloat(retorno))
        return parseFloat(retorno);
    else
        return 0;
}
function compara(tam1,tam2,cam1,cam2){
    alert("entro");
    if(document.getElementById(cam1).length < tam1|| document.getElementById(cam1).length > tam2 ){
        alert("O campo deve ter de "+tam1+" á "+tam2);
        return;
    }
    if(document.getElementById(cam1).value != document.getElementById(cam2).value){
        alert("Os campos não conferem!");
        document.getElementById(cam1).value = "";
        document.getElementById(cam2).value = "";
        document.getElementById(cam1).focus();
        return;
    }
}
function formatar(src, mask){
    var i = src.value.length;
    var saida = mask.substring(0,1);
    var texto = mask.substring(i)
    if (texto.substring(0,1) != saida)
    {
        src.value += texto.substring(0,1);
    }
}

function float_str(valor)
{
    var retorno = '';
    valor = valor.toString();
    var negativo = (valor < 0);
    sep_mil = '.';
    sep_dec = ',';
    var aux, aux2 = '';
    var i = j = 0;
    var strCheck = '0123456789';

    var pos = valor.indexOf('.');
    if (pos == -1)
        valor = valor + '.00';
    else if (valor.length - pos == 2)
        valor = valor + '0';
    else
        valor = valor.substr(0, pos)  + valor.substr(pos+1, 2);

    len = valor.length;
    for(i = 0; i < len; i++)
        if ((valor.charAt(i) != '0') && (valor.charAt(i) != '.')) break;
    aux = '';
    for(; i < len; i++)
        if (strCheck.indexOf(valor.charAt(i))!=-1) aux += valor.charAt(i);
    len = aux.length;
    if (len == 0) retorno = '0,00';
    if (len == 1) retorno = '0'+ sep_dec + '0' + aux;
    if (len == 2) retorno = '0'+ sep_dec + aux;
    if (len > 2)
    {
        aux2 = '';
        for (j = 0, i = len - 3; i >= 0; i--)
        {
            if (j == 3)
            {
                aux2 += sep_mil;
                j = 0;
            }
            aux2 += aux.charAt(i);
            j++;
        }
        retorno = '';
        len2 = aux2.length;
        for (i = len2 - 1; i >= 0; i--)
            retorno += aux2.charAt(i);
        retorno += sep_dec + aux.substr(len - 2, len);
    }
    return (negativo) ? '-' + retorno : retorno;
}


// FUNCOES DE DATA => 003 #########################################################################

function mascara_data(obj)
{
    var v = obj.value;
    v = v.replace( "/", "" );
    v = v.replace( "/", "" );
    if(v.length > 2)
        v = ((v.substr(0,2))+'/'+v.substr(2,8));
    if(v.length > 5)
        v = ((v.substr(0,5))+'/'+v.substr(5,4));

    obj.value = v;
}


function data_valida(data, ano_ini, ano_fim)
{
    erro  = false;
    meses = new Array (31,28,31,30,31,30,31,31,30,31,30,31);

    if (data.length <10)
        erro = true;
    else
    {
        if ((data.substr(2,1) != "/") && (data.substr(5,1) != "/"))
        {
            erro = true;
        }
        else
        {
            d = parseFloat(data.substr(0,2));
            m = parseFloat(data.substr(3,2));
            a = parseFloat(data.substr(6,4));
            if (((d>0) && (d<32)) && ((m>0) && (m<13)) && ((a>=ano_ini) && (a<=ano_fim)))
            {
                if (m==2)
                {
                    if (a%4==0)
                    {
                        if ((d<1) || (d>29))
                            erro = true;
                    }
                    else
                    {
                        if ((d<1) || (d>meses[m-1]))
                            erro = true;
                    }
                }
                else
                {
                    if ((d<1) || (d>meses[m-1]))
                        erro = true;
                }
            }
            else
                erro = true;
        }
    }
    return (!erro);
}

function mascara_hora(campo, evento)
{
    if (window.event)
        var tecla = window.event.keyCode;
    else
    if (evento)
        var tecla = evento.which;
    evento = (window.event) ? window.event : evento;
    vr  = campo.value;
    vr  = vr.replace( ":", "" );
    vr  = vr.replace( ":", "" );
    tam = vr.length + 1;

    if (tecla >= 96 && tecla <= 105)
    {
        if (tam > 3 && tam < 5)
            campo.value = vr.substr(0, tam - 2) + ':' + vr.substr(tam - 2, tam);
        if (tam >= 5 && tam <= 8)
            campo.value = vr.substr(0, 2) + ':' + vr.substr(2, 2) + ':' + vr.substr(4, 2);
    }
    if (evento.type=='blur')
    {
        dif = 7 - tam;
        for(i=0;i<dif;i++)
            vr+=0;
        campo.value = vr.substr(0,2)+':'+vr.substr(2,2)+':'+vr.substr(4,2);
    }
}


function hora_valida(hr)
{
    var hora = new String(hr);
    erro = false;
    if ((hora.length == 8) || (hora.length == 5))
    {
        var    h = new String(hora.substr(0,2));
        var    m = new String(hora.substr(3,2));
        m = parseFloat(m);
        h = parseFloat(h);

        if (hora.length == 5)
        {
            if ((h > 24) || (m > 59))
                erro = true;
        }
        else
        {
            if (hora.length == 8)
            {
                var s = new String(hora.substr(6,2));
                s = parseFloat(s);
                if ((h > 24) || (m > 59) || (s > 59))
                    erro = true;
            }
        }
    }
    else {
        erro = true;
    }
    return (!erro);
}


function mascra_fone(obj)
{
    v = obj.value;
    v = v.replace( "(", "" );
    v = v.replace( ") ", "" );
    v = v.replace( "-", "" );

    if(v.length > 0)
        v = '('+v;
    if(v.length > 3)
        v = ((v.substr(0,3))+') '+v.substr(3,11));
    if(v.length > 9)
        v = ((v.substr(0,9))+'-'+v.substr(9,4));

    obj.value = v;
}


function mascara_moeda(campo, sep_mil, sep_dec, cas_dec, evento)
{
    if (window.event)
        evento = window.event;

    len = campo.value.length;

    vlr = campo.value;
    if (len > 0)
    {
        var whichCode = (window.Event) ? evento.which : evento.keyCode;

        if(whichCode == 107) vlr = vlr.replace("-","");

        if ((whichCode == 109) || (whichCode == 107) || (whichCode >= 48 && whichCode <= 57) || (whichCode >= 96 && whichCode <= 105) || (whichCode == 8) || (whichCode == 46) || (evento.type == 'blur'))
        {
            aux = fmt_float(vlr, sep_mil, sep_dec, cas_dec);
            while (aux.length > campo.maxLength)
            {
                aux2 = aux.substring(0, aux.length -1);
                aux  = fmt_float(aux2, sep_mil, sep_dec, cas_dec);
            }
            campo.value = aux;
        }
    }
}

function fmt_float(valor, sep_mil, sep_dec, cas_dec)
{
    var len = valor.length;

    var negativo = "";
    for(var i = 0; i < len; i++)
    {
        if(valor.charAt(i) == '-')
        {
            negativo = "-";
            valor = valor.replace('-','');
        }
    }

    if (len > 0)
    {
        var strCheck = '0123456789';

        for(i = 0; i < len; i++)
            if ((valor.charAt(i) != '0') && (valor.charAt(i) != sep_dec)) break;
        aux = '';

        for(; i < len; i++)
            if (strCheck.indexOf(valor.charAt(i))!=-1) aux += valor.charAt(i);
        len = aux.length;

        if (cas_dec == 2)
        {
            if (len == 0) aux3 = '0,00';
            if (len == 1) aux3 = '0'+ sep_dec + '0' + aux;
            if (len == 2) aux3 = '0'+ sep_dec + aux;

            if (len > 2)
            {
                aux2 = '';
                for (j = 0, i = len - 3; i >= 0; i--)
                {
                    if (j == 3)
                    {
                        aux2 += sep_mil;
                        j = 0;
                    }
                    aux2 += aux.charAt(i);
                    j++;
                }
                aux3 = '';
                len2 = aux2.length;
                for (i = len2 - 1; i >= 0; i--)
                    aux3 += aux2.charAt(i);
                aux3 += sep_dec + aux.substr(len - 2, len);
            }
        }
        else
        {
            if (cas_dec == 3)
            {
                if (len == 0) aux3 = '0,000';
                if (len == 1) aux3 = '0'+ sep_dec + '00' + aux;
                if (len == 2) aux3 = '0'+ sep_dec + '0' + aux;
                if (len == 3) aux3 = '0'+ sep_dec + aux;

                if (len > 3)
                {
                    aux2 = '';

                    for (j = 0,  i = len - 4;   i >= 0   ; i--)
                    {
                        if (j == 3)
                        {
                            aux2 += sep_mil;
                            j = 0;
                        }
                        aux2 += aux.charAt(i);
                        j++;
                    }


                    aux3 = '';
                    len2 = aux2.length;
                    for (i = len2 - 1; i >= 0; i--)
                        aux3 += aux2.charAt(i);
                    aux3 += sep_dec + aux.substr(len - 3, len);
                }
            }
            if (cas_dec == 4)
            {
                if (len == 0) aux3 = '0,0000';
                if (len == 1) aux3 = '0'+ sep_dec + '000' + aux;
                if (len == 2) aux3 = '0'+ sep_dec + '00' + aux;
                if (len == 3) aux3 = '0'+ sep_dec + '0' + aux;
                if (len == 4) aux3 = '0'+ sep_dec + aux;

                if (len > 4)
                {
                    aux2 = '';

                    for (j = 0,  i = len - 5;   i >= 0   ; i--)
                    {
                        if (j == 3)
                        {
                            aux2 += sep_mil;
                            j = 0;
                        }
                        aux2 += aux.charAt(i);
                        j++;
                    }


                    aux3 = '';
                    len2 = aux2.length;
                    for (i = len2 - 1; i >= 0; i--)
                        aux3 += aux2.charAt(i);
                    aux3 += sep_dec + aux.substr(len - 4, len);
                }
            }
            if (cas_dec == 5)
            {
                if (len == 0) aux3 = '0,00000';
                if (len == 1) aux3 = '0'+ sep_dec + '0000' + aux;
                if (len == 2) aux3 = '0'+ sep_dec + '000' + aux;
                if (len == 3) aux3 = '0'+ sep_dec + '00' + aux;
                if (len == 4) aux3 = '0'+ sep_dec + '0' + aux;
                if (len == 5) aux3 = '0'+ sep_dec + aux;
                if (len > 5)
                {
                    aux2 = '';

                    for (j = 0,  i = len - 6;   i >= 0   ; i--)
                    {
                        if (j == 3)
                        {
                            aux2 += sep_mil;
                            j = 0;
                        }
                        aux2 += aux.charAt(i);
                        j++;
                    }


                    aux3 = '';
                    len2 = aux2.length;
                    for (i = len2 - 1; i >= 0; i--)
                        aux3 += aux2.charAt(i);
                    aux3 += sep_dec + aux.substr(len - 5, len);
                }
            }
        }

        return negativo+aux3;
    }
    else
        return "";
}

function mascara_cpf(campo)
{
    vr = new String(campo.value);
    vr = vr.replace(".", "");
    vr = vr.replace(".", "");
    vr = vr.replace("-", "");

    tam = vr.length + 1 ;

    if (tam > 3 && tam < 7)
        campo.value = vr.substr(0, 3) + '.' + vr.substr(3, tam);
    else if (tam >= 7 && tam < 10)
        campo.value = vr.substr(0,3) + '.' + vr.substr(3,3) + '.' + vr.substr(6,tam-6);
    else if (tam >= 10 && tam < 14)
        campo.value = vr.substr(0,3) + '.' + vr.substr(3,3) + '.' + vr.substr(6,3) + '-' + vr.substr(9,tam-9);
    else if (tam >= 14)
        campo.value = '';
}


function mascara_cnpj(campo, evento)
{
    if (window.event)
        evento = window.event;

    tecla = evento.keyCode;

    vr = new String(campo.value);
    vr = vr.replace(".", "");
    vr = vr.replace(".", "");
    vr = vr.replace("/", "");
    vr = vr.replace("-", "");

    tam = vr.length + 1 ;

    if(tecla != 9 && tecla != 8)
    {
        if(tam > 2 && tam < 6)
            campo.value = vr.substr(0, 2) + '.' + vr.substr(2, tam);
        if(tam >= 6 && tam < 9)
            campo.value = vr.substr(0,2) + '.' + vr.substr(2,3) + '.' + vr.substr(5,tam-5);
        if(tam >= 9 && tam < 13)
            campo.value = vr.substr(0,2) + '.' + vr.substr(2,3) + '.' + vr.substr(5,3) + '/' + vr.substr(8,tam-8);
        if(tam >= 13 && tam < 15)
            campo.value = vr.substr(0,2) + '.' + vr.substr(2,3) + '.' + vr.substr(5,3) + '/' + vr.substr(8,4)+ '-' + vr.substr(12,tam-12);
    }
}


function cpf_valido(valor)
{
    erro = 0;
    aux1 = 0;
    aux2 = 0;
    aux3 = 1;
    for (i=0;i<valor.length-2;i++)
    {
        if ((valor.substr(i,1) != "/") && (valor.substr(i,1) != "-") && (valor.substr(i,1) != "."))
        {
            aux1 = aux1+(11-aux3)*valor.substr(i,1);
            aux2 = aux2+(12-aux3)*valor.substr(i,1);
            aux3++;
        }
    }
    resto = aux1-((Math.floor(aux1/11))*11);
    (resto < 2) ? dig1=0 : dig1=11-resto;
    aux2 = aux2+(2*dig1);
    resto = aux2-((Math.floor(aux2/11))*11);
    (resto < 2) ? dig2=0 : dig2=11-resto;
    aux = dig1+" "+dig2;
    aux = aux.substr(0,1)+aux.substr(2,1);
    if (aux != valor.substr(valor.length-2))
        return false;
    else
    {
        if (
            (valor == "000.000.000-00") ||
            (valor == "111.111.111-11") ||
            (valor == "222.222.222-22") ||
            (valor == "333.333.333-33") ||
            (valor == "444.444.444-44") ||
            (valor == "555.555.555-55") ||
            (valor == "666.666.666-66") ||
            (valor == "777.777.777-77") ||
            (valor == "888.888.888-88") ||
            (valor == "999.999.999-99") ||
            (valor == "00000000000") ||
            (valor == "11111111111") ||
            (valor == "22222222222") ||
            (valor == "33333333333") ||
            (valor == "44444444444") ||
            (valor == "55555555555") ||
            (valor == "66666666666") ||
            (valor == "77777777777") ||
            (valor == "88888888888") ||
            (valor == "99999999999")
                )
            return false;
        else
            return true;
    }
}
function abrir(url,w,h){
    window.open(url,"","status=yes,width="+w+", height="+h);
    return false;
}
function confirma(msg){
    conf = confirm(msg);
    if(conf == 1){
        alert("true");
        return true;
    }else{

        alert("fasle");
        return false;
    }
}

function cnpj_valido(valor)
{
    aux1 = 0;
    aux2 = 0;
    aux3 = 1;
    aux4 = 0;
    for (i=0;i<valor.length-2;i++)
    {
        if ((valor.substr(i,1) != "/") && (valor.substr(i,1) != "-") && (valor.substr(i,1) != "."))
        {
            (aux3 < 5) ? aux4 = 6-aux3 : aux4 = 14-aux3;
            aux1 = aux1+(valor.substr(i,1)*aux4);
            (aux3 < 6) ? aux4 = 7-aux3 : aux4 = 15-aux3;
            aux2 = aux2+(valor.substr(i,1)*aux4);
            aux3++;
        }
    }
    resto = aux1-((Math.floor(aux1/11))*11);
    (resto < 2) ? dig1=0 : dig1=11-resto;
    aux2 = aux2+(2*dig1);
    resto = aux2-((Math.floor(aux2/11))*11);
    (resto < 2) ? dig2=0 : dig2=11-resto;
    aux = dig1+" "+dig2;
    aux = aux.substr(0,1)+aux.substr(2,1);
    if (aux != valor.substr(valor.length-2))
        return false;
    else
        return true;
}