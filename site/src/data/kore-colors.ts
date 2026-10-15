// Generated from kore TailwindColors.kt + RadixColors.kt — do not hand-edit.
// Regenerate with the extractor when Kotlin scales change.

export const tailwindShades = [50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 950] as const;

export const tailwindFamilies: Record<string, string[]> = {
    Slate: ['#f8fafc', '#f1f5f9', '#e2e8f0', '#cbd5e1', '#94a3b8', '#64748b', '#475569', '#334155', '#1e293b', '#0f172a', '#020617'],
    Gray: ['#f9fafb', '#f3f4f6', '#e5e7eb', '#d1d5db', '#9ca3af', '#6b7280', '#4b5563', '#374151', '#1f2937', '#111827', '#030712'],
    Zinc: ['#fafafa', '#f4f4f5', '#e4e4e7', '#d4d4d8', '#a1a1aa', '#71717a', '#52525b', '#3f3f46', '#27272a', '#18181b', '#09090b'],
    Neutral: ['#fafafa', '#f5f5f5', '#e5e5e5', '#d4d4d4', '#a3a3a3', '#737373', '#525252', '#404040', '#262626', '#171717', '#0a0a0a'],
    Stone: ['#fafaf9', '#f5f5f4', '#e7e5e4', '#d6d3d1', '#a8a29e', '#78716c', '#57534e', '#44403c', '#292524', '#1c1917', '#0c0a09'],
    Red: ['#fef2f2', '#fee2e2', '#fecaca', '#fca5a5', '#f87171', '#ef4444', '#dc2626', '#b91c1c', '#991b1b', '#7f1d1d', '#450a0a'],
    Orange: ['#fff7ed', '#ffedd5', '#fed7aa', '#fdba74', '#fb923c', '#f97316', '#ea580c', '#c2410c', '#9a3412', '#7c2d12', '#431407'],
    Amber: ['#fffbeb', '#feefc7', '#fde68a', '#fcd34d', '#fbbf24', '#f59e0b', '#d97706', '#b45309', '#92400e', '#78350f', '#451a03'],
    Yellow: ['#fefce8', '#fef9c3', '#fef08a', '#fde047', '#facc15', '#eab308', '#ca8a04', '#a16207', '#854d0e', '#713f12', '#422006'],
    Lime: ['#f7fee7', '#ecfccb', '#d9f99d', '#bef264', '#a3e635', '#84cc16', '#65a30d', '#4d7c0f', '#3f6212', '#365314', '#1a2e05'],
    Green: ['#f0fdf4', '#dcfce7', '#bbf7d0', '#86efac', '#4ade80', '#22c55e', '#16a34a', '#15803d', '#166534', '#14532d', '#052e16'],
    Emerald: ['#ecfdf5', '#d1fae5', '#a7f3d0', '#6ee7b7', '#34d399', '#10b981', '#059669', '#047857', '#065f46', '#064e3b', '#022c22'],
    Teal: ['#f0fdfa', '#ccfbf1', '#99f6e4', '#5eead4', '#2dd4bf', '#14b8a6', '#0d9488', '#0f766e', '#115e59', '#134e4a', '#042f2e'],
    Cyan: ['#ecfeff', '#cefefe', '#affaf8', '#67e8f9', '#22d3ee', '#06b6d4', '#0891b2', '#0e7490', '#155e75', '#164e63', '#083344'],
    Sky: ['#f0f9ff', '#e0f2fe', '#bae6fd', '#7dd3fc', '#38bdf8', '#0ea5e9', '#0284c7', '#0369a1', '#075985', '#0c4a6e', '#082f49'],
    Blue: ['#eff6ff', '#dbeafe', '#bfdbfe', '#93c5fd', '#60a5fa', '#3b82f6', '#2563eb', '#1d4ed8', '#1e40af', '#1e3a8a', '#172554'],
    Indigo: ['#eef2ff', '#e0e7ff', '#c7d2fe', '#a5b4fc', '#818cf8', '#6366f1', '#4f46e5', '#4338ca', '#3730a3', '#312e81', '#1e1b4b'],
    Violet: ['#f5f3ff', '#ede9fe', '#ddd6fe', '#c4b5fd', '#a78bfa', '#8b5cf6', '#7c3aed', '#6d28d9', '#5b21b6', '#4c1d95', '#2e1065'],
    Purple: ['#faf5ff', '#f3e8ff', '#e9d5ff', '#d8b4fe', '#c084fc', '#a855f7', '#9333ea', '#7e22ce', '#6b21a8', '#581c87', '#3b0764'],
    Fuchsia: ['#fdf4ff', '#fae8ff', '#f5d0fe', '#f0abfc', '#e879f9', '#d946ef', '#c026d3', '#a21caf', '#86198f', '#701a75', '#4a044e'],
    Pink: ['#fdf2f8', '#fce7f3', '#fbcfe8', '#f9a8d4', '#f472b6', '#ec4899', '#db2777', '#be185d', '#9d174d', '#831843', '#500724'],
    Rose: ['#fff1f2', '#ffe4e6', '#fecdd3', '#fda4af', '#fb7185', '#f43f5e', '#e11d48', '#be123c', '#9f1239', '#881337', '#4c0519']
};

export const radixSteps = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] as const;

export interface RadixScale { light: string[]; dark: string[]; }

export const radixScales: Record<string, RadixScale> = {
    Gray: { light: ['#fcfcfc', '#f9f9f9', '#f0f0f0', '#e8e8e8', '#e0e0e0', '#d9d9d9', '#cecece', '#bbbbbb', '#8d8d8d', '#838383', '#646464', '#202020'], dark: ['#111111', '#191919', '#222222', '#2a2a2a', '#313131', '#3a3a3a', '#484848', '#606060', '#6e6e6e', '#7b7b7b', '#b4b4b4', '#eeeeee'] },
    Mauve: { light: ['#fdfcfd', '#faf9fb', '#f2eff3', '#eae7ec', '#e3dfe6', '#dbd8e0', '#d0cdd7', '#bcbac7', '#8e8c99', '#84828e', '#65636d', '#211f26'], dark: ['#121113', '#1a191b', '#232225', '#2b292d', '#323035', '#3c393f', '#49474e', '#625f69', '#6f6d78', '#7c7a85', '#b5b2bc', '#eeeef0'] },
    Slate: { light: ['#fcfcfd', '#f9f9fb', '#f0f0f3', '#e8e8ed', '#e0e1e6', '#d9d9e0', '#cdced6', '#b9bbc6', '#8b8d98', '#80838d', '#60646c', '#1c2024'], dark: ['#111113', '#18191b', '#212225', '#272a2d', '#2e3135', '#363a3f', '#43484e', '#5a6169', '#696e77', '#777b84', '#b0b4ba', '#edeef0'] },
    Sage: { light: ['#fbfdfc', '#f7f9f8', '#eef1f0', '#e6e9e8', '#dfe2e0', '#d7dad9', '#cbcfcd', '#b8bcba', '#868e8b', '#7c8481', '#5f6563', '#1a211e'], dark: ['#101211', '#171918', '#202221', '#272a29', '#2e3130', '#373b39', '#444947', '#5b6360', '#63706b', '#717d79', '#adb5b2', '#eceeed'] },
    Olive: { light: ['#fcfdfc', '#f8faf8', '#eff1ef', '#e7e9e7', '#dfe2df', '#d7dad7', '#cbcecb', '#b9bcb8', '#898e87', '#7f847d', '#60655f', '#1d211c'], dark: ['#111210', '#181917', '#212220', '#282a27', '#2f312e', '#383a36', '#454843', '#5c625b', '#687066', '#767d74', '#afb5ad', '#eceeec'] },
    Sand: { light: ['#fdfdfc', '#f9f9f8', '#f1f0ef', '#e9e8e6', '#e2e1de', '#dad9d6', '#cfceca', '#bcbbb5', '#8d8d86', '#82827c', '#63635e', '#21201c'], dark: ['#111110', '#191916', '#22211e', '#2a2925', '#31302b', '#3b3a35', '#494841', '#62605b', '#6f6d66', '#7c7b74', '#b5b3ad', '#eeeeec'] },
    Gold: { light: ['#fdfdfc', '#faf9f2', '#f2f0e7', '#eae6d7', '#e1dbc8', '#d4cdb5', '#c2b99a', '#a9991b', '#978365', '#8c7a5e', '#71624b', '#3b3422'], dark: ['#121211', '#1b1a17', '#24231f', '#2d2b26', '#35332d', '#3e3c35', '#504e45', '#6b6757', '#978365', '#a39073', '#cbb99a', '#e8e2d9'] },
    Bronze: { light: ['#fdfcfc', '#fdf8f6', '#f6edea', '#ede3df', '#e3d9d3', '#d8cdc6', '#c8bdb4', '#b1a49a', '#9c8d84', '#91827a', '#6f6460', '#282120'], dark: ['#141110', '#1c1917', '#262220', '#302a27', '#3b3330', '#463d39', '#594f4a', '#6f6259', '#9c8d84', '#a99991', '#d4bdb6', '#ede0da'] },
    Brown: { light: ['#fefdfc', '#fcf9f6', '#f6eee7', '#f0e4d9', '#ebdacd', '#e3cfc0', '#d9c0ad', '#cbaa91', '#ad7f58', '#a07652', '#815e46', '#3e2712'], dark: ['#12110f', '#1c1916', '#28211a', '#322922', '#3e3128', '#4d3c2f', '#614a39', '#7c5f46', '#ad7f58', '#b98c67', '#dbb594', '#f2e1ca'] },
    Yellow: { light: ['#fdfdf9', '#fffce8', '#fffbd1', '#fff8bb', '#fef2a4', '#f9e68c', '#efd36c', '#ebbc00', '#f5d90a', '#f7ce00', '#946800', '#35290f'], dark: ['#14120b', '#1b180f', '#2d2305', '#362b00', '#433500', '#524202', '#665417', '#836a21', '#f5d90a', '#ffef5c', '#f6ef5b', '#fffad1'] },
    Amber: { light: ['#fefdfb', '#fff9ed', '#fff4d5', '#ffecbc', '#ffe3a2', '#ffd386', '#f3ba63', '#ee9d2b', '#ffb224', '#ffa01c', '#ad5700', '#4e2009'], dark: ['#16120b', '#1d180f', '#302008', '#3f2700', '#4d3000', '#5c3d05', '#714f19', '#8f6424', '#ffb224', '#ffcb47', '#f1a10d', '#fef3dd'] },
    Orange: { light: ['#fefcfb', '#fff7ed', '#ffefd6', '#ffdfb5', '#ffd19a', '#ffc182', '#f5ae73', '#ec9455', '#f76b15', '#ef5f00', '#cc4e00', '#582d1d'], dark: ['#17120e', '#1e160f', '#331e0b', '#462100', '#562800', '#66350c', '#7e451d', '#a35829', '#f76b15', '#ff801f', '#ff8b3e', '#feedd5'] },
    Tomato: { light: ['#fffcfc', '#fff8f7', '#feebe7', '#ffddd6', '#ffcdc2', '#fdbdaf', '#f5a898', '#ec8e7b', '#e54d2e', '#db4324', '#ca3214', '#5c1a10'], dark: ['#181111', '#1f1513', '#391714', '#4e1511', '#5e1c16', '#722522', '#8c3329', '#b54739', '#e54d2e', '#ec6142', '#ff977d', '#fbd3cb'] },
    Red: { light: ['#fffcfc', '#fff7f7', '#feebec', '#ffdbdc', '#ffcdce', '#fdbdbe', '#f4a9aa', '#eb8e90', '#e5484d', '#da3f44', '#ce2c31', '#641723'], dark: ['#191111', '#201314', '#3b1219', '#500f1c', '#611623', '#72232d', '#8c333a', '#b54548', '#e5484d', '#ec5d5e', '#ff9592', '#ffd1d9'] },
    Ruby: { light: ['#fffcfd', '#fff7f8', '#feeaed', '#ffdbe1', '#ffced6', '#f8bfc8', '#efacb8', '#e592a3', '#e54666', '#da3b5a', '#ca244d', '#64172b'], dark: ['#191113', '#200f14', '#3b0f1f', '#500f27', '#601730', '#72263b', '#8c334b', '#b34468', '#e54666', '#ec5a72', '#ff949d', '#ffd1dc'] },
    Crimson: { light: ['#fffcfd', '#fef7f9', '#ffe9f0', '#fedce8', '#facedd', '#f3bed1', '#e8abc0', '#e093aa', '#e93d82', '#df3278', '#cb1d63', '#621639'], dark: ['#191114', '#200f17', '#3a102a', '#4e1036', '#5e1842', '#6f2751', '#883464', '#b04478', '#e93d82', '#ee518a', '#ff92ad', '#fdd3e8'] },
    Pink: { light: ['#fffcfe', '#fef7fb', '#fdeaf4', '#faddef', '#f6cfe8', '#efbfdf', '#e7acd4', '#dd93c2', '#d6409f', '#cf3897', '#c2298a', '#651249'], dark: ['#191117', '#21101c', '#37122e', '#4b143d', '#591c47', '#692955', '#833869', '#a84885', '#d6409f', '#de51a8', '#ff8dcc', '#fdd1ea'] },
    Plum: { light: ['#fefcff', '#fdf7ff', '#fbebff', '#f7deff', '#f2d1ff', '#e9c2f9', '#deaef4', '#cf91e8', '#ab4aba', '#a144af', '#953ea3', '#53195d'], dark: ['#181118', '#201320', '#351a35', '#451d47', '#532557', '#633263', '#7c4082', '#9f55a6', '#ab4aba', '#b658c4', '#e796f3', '#f4d4f4'] },
    Purple: { light: ['#fefcfe', '#fbf7fe', '#f7edfe', '#f2e2fc', '#ead5f9', '#e0c4f4', '#d1afec', '#be93e4', '#8e4ec6', '#8347b9', '#7938b2', '#402060'], dark: ['#18111b', '#1e1523', '#301c3b', '#3d224e', '#48295c', '#54346b', '#664282', '#8457aa', '#8e4ec6', '#9a5cd0', '#d19dff', '#ecd9fa'] },
    Violet: { light: ['#fdfcfe', '#faf8ff', '#f4f0fe', '#ede9fe', '#e4defc', '#d7cff9', '#c4b8f3', '#aa99ec', '#6e56cf', '#654dc4', '#6550b9', '#2f265f'], dark: ['#14121f', '#1b1525', '#291f43', '#33255a', '#3c2e69', '#473876', '#56468b', '#6958ad', '#6e56cf', '#7d66d9', '#baa7ff', '#e2dffe'] },
    Iris: { light: ['#fdfcff', '#f8f8ff', '#f0f1fe', '#e6e7fd', '#dadcfb', '#cbcef8', '#b8bdf4', '#9da3ee', '#5b5bd6', '#5151cd', '#5753c6', '#272962'], dark: ['#13131e', '#171625', '#202248', '#262a65', '#303374', '#3d3e82', '#4a4d96', '#5b60b5', '#5b5bd6', '#6e6ade', '#b1aeff', '#e0dffe'] },
    Indigo: { light: ['#fdfdfe', '#f7f9ff', '#edf2fe', '#e1eafd', '#d2dffb', '#c1d0f9', '#abbdf5', '#8da4ef', '#3e63dd', '#3a5ccc', '#3451b2', '#1f306e'], dark: ['#11131f', '#141726', '#182449', '#1d2e62', '#253974', '#304384', '#3a549a', '#4164c2', '#3e63dd', '#5472e4', '#9eb1ff', '#d6e1ff'] },
    Blue: { light: ['#fbfdff', '#f4faff', '#e6f4fe', '#d5efff', '#c2e5ff', '#acd8fc', '#8ec8f6', '#5eb1ef', '#0090ff', '#0588f0', '#0d74ce', '#113264'], dark: ['#0d1520', '#111927', '#0d2847', '#003362', '#004074', '#104d87', '#205d9e', '#2870bd', '#0090ff', '#3b9eff', '#70b8ff', '#c2e6ff'] },
    Cyan: { light: ['#fafdfe', '#f2fafb', '#def7f9', '#caf1f6', '#b5e9f0', '#9ddde7', '#7dcfdb', '#3db9cf', '#00a2c7', '#0797b9', '#107d98', '#0d3c48'], dark: ['#0b161a', '#101b20', '#082c36', '#003848', '#004558', '#045468', '#12677e', '#11809c', '#00a2c7', '#23afd0', '#4ccce6', '#b6ecf7'] },
    Teal: { light: ['#fafefd', '#f3fbf9', '#e0f8f3', '#ccf3ea', '#b8eae0', '#a1ddd4', '#83cdc5', '#53b9b0', '#12a594', '#0d9b8a', '#008573', '#0d3d38'], dark: ['#0d1514', '#111c1b', '#0d2d2a', '#023b37', '#084843', '#145750', '#1c6961', '#207e73', '#12a594', '#0eb39e', '#0bd8b6', '#adf0dd'] },
    Jade: { light: ['#fbfefd', '#f4fbf7', '#e6f7ed', '#d6f1e3', '#c3e9d7', '#acdec8', '#8bceb5', '#56ba9f', '#29a383', '#26997b', '#208368', '#1d3b31'], dark: ['#0d1512', '#121c18', '#0f2e22', '#0b3b2c', '#114837', '#1b5745', '#246854', '#2a7e67', '#29a383', '#27b08b', '#1fd8a4', '#adf0d4'] },
    Green: { light: ['#fbfefb', '#f3fcf3', '#e5f9e7', '#d6f1da', '#c4e8ca', '#adddb9', '#8ecea3', '#5bb98c', '#30a46c', '#2b9a66', '#218358', '#193b2d'], dark: ['#0e1512', '#121b17', '#132d21', '#113b29', '#174933', '#20573e', '#28684a', '#2f7c57', '#30a46c', '#33b074', '#3dd68c', '#b1f1cb'] },
    Grass: { light: ['#fbfefb', '#f5fbf5', '#e9f6e9', '#daf1db', '#c9e8ca', '#b2ddb5', '#94ce9a', '#65ba74', '#46a758', '#3d9e4e', '#297c3b', '#1b311e'], dark: ['#0d1407', '#11190b', '#132b0e', '#1d3a14', '#25461b', '#2d5423', '#36642b', '#3d7834', '#46a758', '#53b365', '#71d083', '#c2f0c2'] },
    Lime: { light: ['#fcfdfa', '#f8faf3', '#eff5e0', '#e5efcd', '#dae8bb', '#cde0a4', '#b8d383', '#9dc06b', '#bde56c', '#b3d94f', '#5c7c10', '#2c3a10'], dark: ['#11130c', '#151a10', '#1f2917', '#29371d', '#334423', '#3d522a', '#496231', '#577538', '#bde56c', '#d4f070', '#bde56c', '#e3f7ba'] },
    Mint: { light: ['#f9fefd', '#f2fbf9', '#ddf9f1', '#c8f4e9', '#b3ecde', '#9ae3d1', '#7dd5bf', '#4cc4a9', '#86ead4', '#7de0cb', '#027864', '#16302b'], dark: ['#0e1515', '#0f1b1b', '#092c2b', '#003a38', '#004744', '#105552', '#1e6462', '#277f7a', '#86ead4', '#a8f5e5', '#58d5ba', '#c4f5e1'] },
    Sky: { light: ['#f9feff', '#f1fafd', '#e1f6fd', '#d1f0fa', '#bee7f5', '#a9daed', '#8dcae3', '#60b3d7', '#7ce2fe', '#74daf8', '#00749e', '#1d3e56'], dark: ['#0d1520', '#111b27', '#112840', '#113555', '#154467', '#1b537b', '#1f6692', '#197cae', '#7ce2fe', '#a8eeff', '#75c7f0', '#c2f3ff'] }
};
