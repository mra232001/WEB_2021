var a = 1;
function show_hide()
{
    if(a==1)
    {
        document.getElementById("container_comment").style.display="inline";
        return a=0;
    }
    else
    {
        document.getElementById("container_comment").style.display="none";
        return a=1;
    }
}

function change_color()
{
    document.getElementById('heart').addEventListener('click', function () {
        this.style.backgroundColor = this.style.backgroundColor === 'pink' ? 'white' : 'pink';
    });

}