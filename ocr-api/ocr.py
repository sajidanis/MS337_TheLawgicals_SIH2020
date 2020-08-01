from PIL import Image
import pytesseract
import requests

def ocr_text(url):
    img = Image.open(requests.get(url, stream=True).raw)
    text = pytesseract.image_to_string(img)
    return text
