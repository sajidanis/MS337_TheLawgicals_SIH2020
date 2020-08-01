from flask import Flask, request, jsonify
from ocr import ocr_text

app = Flask(__name__)

#pytesseract.pytesseract.tesseract_cmd = ‘/app/.apt/usr/bin/tesseract’

@app.route("/ocr", methods=['GET', 'POST'])
def ocr_api():
    if request.method == 'POST':
        post_data = request.get_json()
        url = post_data['url']
        if url.split('.')[-1] in ['jpg', 'png']:
            text = ocr_text(url)
            return jsonify({"text": text})
        else:
            return jsonify({"error": "invalid image format, we only support png/jpg"})

if __name__ == "__main__":
        app.run(threaded=True, port=5000)
