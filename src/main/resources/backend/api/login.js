function loginApi(data) {
  return $axios({
    'url': '/employee/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/employee/logout',
    'method': 'post',
  })
}


const langToggleBtn = document.getElementById('lang-toggle');
const langToggleImg = langToggleBtn.getElementsByTagName('img')[0];
const langToggleText = langToggleBtn.getElementsByTagName('span')[0];

langToggleBtn.addEventListener('click', function() {
  if (langToggleImg.src === 'https://upload.wikimedia.org/wikipedia/en/a/ae/Flag_of_the_United_Kingdom.svg') {
    langToggleImg.src = 'https://upload.wikimedia.org/wikipedia/commons/f/fa/Flag_of_the_People%27s_Republic_of_China.svg';
    langToggleText.innerText = 'CH';
  } else {
    langToggleImg.src = 'https://upload.wikimedia.org/wikipedia/en/a/ae/Flag_of_the_United_Kingdom.svg';
    langToggleText.innerText = 'EN';
  }
});
