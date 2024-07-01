document.getElementById('candidaturaForm').addEventListener('submit', function(event) {
    var fileInput = document.getElementById('arquivo');
    var fileSizeError = document.getElementById('fileSizeError');

    if (fileInput.files[0].size > 1048576) {
        fileSizeError.style.display = 'block';
        event.preventDefault();
    } else {
        fileSizeError.style.display = 'none';
    }
});