export async function getPoem(prompt: string, setData: (value) => void, max_tokens?: number ) {
    const API_KEY = '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';

    const payload = {
        prompt: `Generate a poem inspired by the following prompt: "${prompt}"`,
        model: 'text-davinci-003',
        max_tokens: max_tokens === undefined ? 50 : max_tokens,
        n: 1
    };

    fetch("https://api.openai.com/v1/completions", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${API_KEY}`,
        },
        body: JSON.stringify(payload),
    }).then(response => response.json())
        .then(data => {
            setData(data.choices[0].text);
            return;
        })
        .catch((error) => {
            console.log("Error: ", error);
        });
}

export async function getImageURL(prompt: string, setData: (value) => void) {
    const payload = {
        prompt: prompt.toString(),
        n: 1,
        size: "256x256"
    };

    fetch('http://localhost:4040/images/generate', {
        method: 'POST',
        body: JSON.stringify(payload),
    }).then(response => response.json())
        .then(data => {
            setData(data.data[0].url);
            return;
        })
        .catch((error) => {
            console.log("Error: ", error);
        });
}