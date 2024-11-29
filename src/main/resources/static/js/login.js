document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const userId = document.getElementById('userId').value;
    const userPw = document.getElementById('userPw').value;
    console.log(userId);

    try {
        const response = await fetch('/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ userId, userPw })
        });

        if (response.ok) {
            const result = await response.json();
            if (result.success) {
                Swal.fire({
                    icon: 'success',
                    title: '로그인 성공!',
                    text: '환영합니다!',
                    confirmButtonText: '확인'
                }).then(() => {
                    window.location.href = '/home';
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: '로그인 실패',
                    text: '아이디 또는 비밀번호를 확인해주세요.',
                    confirmButtonText: '확인'
                });
            }
        } else {
            throw new Error('서버 응답 에러');
        }
    } catch (error) {
        Swal.fire({
            icon: 'error',
            title: '에러 발생',
            text: '로그인 중 문제가 발생했습니다. 다시 시도해주세요.',
            confirmButtonText: '확인'
        });
    }
});
