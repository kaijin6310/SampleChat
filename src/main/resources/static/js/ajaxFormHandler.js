document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll("form.ajax-form").forEach(form => {
        form.addEventListener("submit", function (event) {
            event.preventDefault(); // 通常のフォーム送信を防ぐ

            let formData = new FormData(this);
            let actionUrl = this.getAttribute("action") || window.location.href; // actionがなければ現在のURL

            fetch(actionUrl, {
                method: "POST",
                body: formData
            })
                .then(response => response.text()) // レスポンスをテキストとして取得
                .then(message => {

                    let messageTarget = this.getAttribute("data-message-target"); // メッセージを表示する要素
                    if (messageTarget) {
                        let targetElement = document.querySelector(messageTarget);
                        if (targetElement) {
                            targetElement.textContent = message;
                            targetElement.style.color = "green";
                        } else {
                            console.error("メッセージを表示する要素が見つかりません:", messageTarget);
                        }
                    }
                })
                .catch(error => {
                    console.error("エラー:", error);
                });
        });
    });
});
