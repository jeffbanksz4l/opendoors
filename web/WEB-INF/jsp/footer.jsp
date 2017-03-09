<!-- Footer -->
<footer class="w3-container w3-padding-16">
    <i class="fa fa-github fa-fw w3-large"></i>
    <i class="fa fa-linkedin-square fa-fw w3-large"></i>
    <i class="fa fa-envelope-square fa-fw w3-large"></i>
    <p>Copyright <i class="fa fa-copyright fa-fw"></i> Jeffrey Banks</p>
</footer>

<!-- End page content -->
</div>

<script>
// Get the Sidenav
    var mySidenav = document.getElementById("mySidenav");

// Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidenav, and add overlay effect
    function w3_open() {
        if (mySidenav.style.display === 'block') {
            mySidenav.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidenav.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

// Close the sidenav with the close button
    function w3_close() {
        mySidenav.style.display = "none";
        overlayBg.style.display = "none";
    }

    function logoutFormSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

</body>
</html>