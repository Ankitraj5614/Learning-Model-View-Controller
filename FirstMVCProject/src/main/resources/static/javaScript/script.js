/**
 * 
 */
document.querySelectorAll(".deleteBtn").forEach(button => {

    button.addEventListener("click", function(e){

        if(!confirm("Are you sure you want to delete this user?")){
            e.preventDefault();
        }

    });

});
const search = document.getElementById("search");

search.addEventListener("keyup", function () {

    let filter = search.value.toLowerCase();

    let rows = document.querySelectorAll("#tableBody tr");

    rows.forEach(row => {

        let text = row.innerText.toLowerCase();

        row.style.display = text.includes(filter) ? "" : "none";

    });

});