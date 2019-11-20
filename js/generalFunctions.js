function hideSearchBar() {
  var searchBar = document.getElementById("searchBar");
  if (window.innerWidth < 695) {
    searchBar.style.display = "none";
  }
  else {
    searchBar.style.display = "initial";
  }
}